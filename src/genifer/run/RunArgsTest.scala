package genifer.run

object RunArgsTest {
	
  def main(args : Array[String]) : Unit = {
	  System.out.println("X:")
	  for (val arg <- args)
	 	  if (arg.startsWith("-"))
	 	 	  System.out.println(" " + arg.substring(1))
	  
  }
  
}
