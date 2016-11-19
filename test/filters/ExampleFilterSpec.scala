/*
 * Copyright 2016 Thorben Stangenberg <thorben@stangenberg.net>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package filters

import akka.stream.Materializer
import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.mvc.Action
import play.api.mvc.Results._
import play.api.test.{FakeRequest, Helpers}
import play.api.test.Helpers._
import scala.concurrent.ExecutionContext.Implicits.global

class ExampleFilterSpec extends PlaySpec with OneAppPerSuite {

  implicit lazy val materializer: Materializer = app.materializer

  "Example filter" should {
    "add an example header" in {
      val filter = new ExampleFilter()
      val rh = FakeRequest()
      val action = Action(Ok("success"))
      val result = call(filter(action), rh)
      header("X-ExampleFilter", result) mustBe Option("foo")
    }
  }
}