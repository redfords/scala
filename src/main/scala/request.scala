import requests.Response

object request {
//  a simple GET request can be made using the get method:

  val r: Response = requests.get("https://api.github.com/users/baeldung")

//  this returns a Response instance where we can use the text method:

  val responseText = r.text
  assert(responseText.contains("http://www.baeldung.com"))
  assert(r.statusCode == 200)
  assert(r.contentType.exists(_.contains("application/json")))

//  The get method allows us to provide query parameters as a Map:

  val responseMap = requests.get("http://httpbin.org/get", params = Map("key1" -> "value1"))
  assert(responseMap.statusCode == 200)

//  let's invoke a REST API with basic authentication:

  val responseAuth = requests.get("https://postman-echo.com/basic-auth", auth = ("postman","password"))
  assert(responseAuth.statusCode == 200)
  assert(responseAuth.text().contains("true"))
}
