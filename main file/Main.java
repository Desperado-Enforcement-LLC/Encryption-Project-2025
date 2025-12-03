class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    //First use a simple string with a z in it
    String msg ="ABCDXYZ abz";

    String encodedMsg = encode(msg);
    
    System.out.println("Original msg: "+msg);
    System.out.println("encoded msg: "+encodedMsg);

    // now read a file encode and save file
    msg = Input.readFile("Original.txt");
    encodedMsg = encode(msg);
    Input.writeFile("Encode.txt",encodedMsg);

    // now decode the encode message

    encodedMsg = Input.readFile("Encode.txt");
    String decodedMsg = decode(encodedMsg);
    Input.writeFile("Decoded.txt",decodedMsg);
    
    
    
  }

   String encode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      
      if(ascii == 90){
        ascii = 65;
      }
      else if( ascii == 122){
        ascii = 97;
      }
      else{
        ascii+=1;
      }
      bld+= (char)ascii;
    }
     
    return bld;
  }

  
  String decode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      
      if(ascii == 65){
        ascii = 90;
      }
      else if( ascii == 97){
        ascii = 122;
      }
      else{
        ascii-=1;
      }
      bld+= (char)ascii;
    }
    return bld;
  }

  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}