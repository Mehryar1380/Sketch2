PVector acce[] = new PVector[10];
PVector velo[] = new PVector[10];
PVector loca[] = new PVector[10];

void setup(){
  
  size(500,500); //Size of the screen

  for(int i = 0 ; i<9;i++){
    loca[i] = new PVector(width/2,height/2); // Initializes a location for the Vectors(circle)
    velo[i] = new PVector(0,0); // Initializes a velocity 
    
    
  }
  
}

void draw(){
 
 fill(0,50);//changes the screen to black but also allows the colored path to show and slowly fadeaway
 rect(0,0,width,height);// Prints a black screen on top
 for(int i= 0;i<9;i++){

   PVector direc = new PVector(random(500),random(500)); // A random vector generated 
   acce[i] = PVector.sub(direc, loca[i]);// Subtracts the random vector to allow the ellipses to move
  
   
 acce[i].mult(.5);// Multiplies the accelerrating vector by .5
 velo[i].div(.9); //Divides the velocity vector by .9 to allow the ellipses to be more farapart
 acce[i].normalize(); // normalizes the accelleration of the vector 
 velo[i].add(acce[i]);// Connect velocity of the vector to the acceleration
 loca[i].add(velo[i]); // Connect the direction of the vector to the velocity
 velo[i].limit(10);// Limit the velocity to 10
 
 
 float x = loca[i].x;
 float y = loca[i].y;
 noStroke();
 fill(random(255),random(255), random(255)); 
 
 ellipse(x,y,10,10);



 }
}
