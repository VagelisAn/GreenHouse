#define SLAVE_EN  8
#define LED       13
String recInput;                                // Variable to store Receive string 

void setup() {
  pinMode(LED , OUTPUT);                        // Declare LED pin as output
  pinMode(SLAVE_EN , OUTPUT);                   // Declare Enable pin as output
  Serial.begin(9600);                           // set serial communication baudrate 
  digitalWrite(SLAVE_EN , LOW);                 // Make Enable pin low, Receiving mode ON 
}

void loop() {
  while(Serial.available())                     // If serial data is available then enter into while loop
  {
    recInput = Serial.readStringUntil('*');     // Receive Serial data in Variable
    Serial.print(recInput);                     // Print Data
    
    if(recInput == "EMBEDDED GATE")             // Compare Data
    {
      digitalWrite( LED , HIGH);    // LED ON
      delay(1000);
      digitalWrite( LED , LOW);     // LED OFF
    }
  }
}
