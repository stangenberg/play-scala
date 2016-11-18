package controllers

import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

class AsyncControllerTest extends PlaySpec with OneAppPerTest {

  "AsyncController" should {

    "render the message" in {
      val home = route(app, FakeRequest(GET, "/message")).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/plain")
      contentAsString(home) must include ("Hi!")
    }

  }

}
