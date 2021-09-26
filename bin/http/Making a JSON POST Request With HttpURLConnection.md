2. Building a JSON POST Request With HttpURLConnection
2.1. Create a URL Object
Let's create a URL object with a target URI string that accepts the JSON data via HTTP POST method:

URL url = new URL ("https://reqres.in/api/users");
2.2. Open a Connection
From the above URL object, we can invoke the openConnection method to get the HttpURLConnection object.

We can't instantiate HttpURLConnection directly, as it's an abstract class:

HttpURLConnection con = (HttpURLConnection)url.openConnection();
2.3. Set the Request Method
To send a POST request, we'll have to set the request method property to POST:


freestar
con.setRequestMethod("POST");
2.4. Set the Request Content-Type Header Parameter
Set the “content-type” request header to “application/json” to send the request content in JSON form. This parameter has to be set to send the request body in JSON format.

Failing to do so, the server returns HTTP status code “400-bad request”:

con.setRequestProperty("Content-Type", "application/json; utf-8");
Also, note that we've mentioned charset encoding along with content type. This is useful if the request content encoding is different from UTF-8 encoding, which is the default encoding.

2.5. Set Response Format Type
Set the “Accept” request header to “application/json” to read the response in the desired format:

con.setRequestProperty("Accept", "application/json");
2.6. Ensure the Connection Will Be Used to Send Content
To send request content, let's enable the URLConnection object's doOutput property to true.


freestar
Otherwise, we won't be able to write content to the connection output stream:

con.setDoOutput(true);
2.7. Create the Request Body
After creating a custom JSON String:

String jsonInputString = "{"name": "Upendra", "job": "Programmer"}";
We would need to write it:

try(OutputStream os = con.getOutputStream()) {
    byte[] input = jsonInputString.getBytes("utf-8");
    os.write(input, 0, input.length);			
}
2.8. Read the Response From Input Stream
Get the input stream to read the response content. Remember to use try-with-resources to close the response stream automatically.

Read through the whole response content, and print the final response string:


freestar
try(BufferedReader br = new BufferedReader(
  new InputStreamReader(con.getInputStream(), "utf-8"))) {
    StringBuilder response = new StringBuilder();
    String responseLine = null;
    while ((responseLine = br.readLine()) != null) {
        response.append(responseLine.trim());
    }
    System.out.println(response.toString());
}
If the response is in JSON format, use any third-party JSON parsers such as Jackson library, Gson, or org.json to parse the response.