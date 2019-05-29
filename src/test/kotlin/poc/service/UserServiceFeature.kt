package poc.service

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.amshove.kluent.`should be equal to`
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import poc.model.User
import poc.repository.UserRepository

object UserServiceFeature : Spek({
    Feature("UserService") {
        Scenario("Find user by id") {
            val userId = 1L
            val userName = "Peter"
            lateinit var user: User
            lateinit var userRepository: UserRepository
            lateinit var userService: UserService
            lateinit var result: User

            Given("User exist in Repository") {
                user = User(
                    id = userId,
                    name = userName
                )
                userRepository = mock {
                    on { findById(userId) } doReturn user
                }
            }

            And("UserService is constructed") {
                userService = UserService(userRepository)
            }

            When("We use UserService to find the User by id = $userId") {
                result = userService.findById(userId)
            }

            Then("The id of the result should be \"$userId\"") {
                result.id `should be equal to` userId
            }

            And("The name of the result should be \"$userName\"") {
                result.name `should be equal to` user.name
            }
        }
    }
})
