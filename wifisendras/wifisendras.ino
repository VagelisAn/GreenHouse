#include <ArduinoJson.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

const char* ssid = "COSMOTE-606804";
const char* password = "nrfxkbfh29rs5h2s";

void setup() {
  Serial.begin(115200);

  //TESTING JSON CREATION
  Serial.println("Starting JSON");
  StaticJsonBuffer<69> jsonBuffer;
  String json = "{\"name\":\"Test\",\"type\":\"dfsfsd\",\"model\":\"saaaa\",\"temperayure\":3.14,\"humidity\":35.55,\"greenHouse\":\"Test\"}";
//  JsonObject& root = jsonBuffer.parseObject(json);
//  Serial.println(json);
//  if(!root.success()) {
//    Serial.println("parseObject() failed");
//  } else {
//    Serial.println("JSON OK");
//  }


  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting... ");
  }


  //TESTING POST
  //headers={'content-type': 'application/json', 'auth-key': 'My_authentication_key'}
  String sms_service_URL = "http://192.168.1.111:8080/temp";


  Serial.println("TESTING POST");
  //Declare an object of class HTTPClient
  HTTPClient http;

  if (WiFi.status() == WL_CONNECTED) {
    //Specify request destination
    http.begin(sms_service_URL);
    http.addHeader("Content-Type", "application/json");
    //http.addHeader("auth-key", "My_authentication_key");

    String data;
//    root.printTo(data);
Serial.println(json);
    //Send the request
    int httpCode = http.POST(json);
    Serial.println(httpCode);
    //Check the returning code
    if (httpCode > 0) { 
      //Get the request response payload
      String payload = http.getString();
      //Print the response payload
      Serial.println(payload);
    }
    //Close connection
    http.end();
    Serial.println(httpCode);
  }
}

void loop() {


}
