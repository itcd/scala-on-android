import example._

object Main extends App{
  triangle
  println(balance("())(".toList))
  println(balance("(just an) example".toList))
  println(countChange(4,List(1, 2)))
  
  def pascal(c: Int, r: Int): Int = if(r==c || c==1) 1 else pascal(c,r-1)+pascal(c-1,r-1)

  def triangle(): Unit = 
  {
    var map = Map((0,0) -> 0)
    for(i <- 1 to 5) {
      for(j<-1 to i){
        var v:Int=0
        map.get((j,i)) match {
          case Some(x) => v=x
          case None => {v=pascal(j,i);map += (i,j) -> v}
        }
        print(v)
        print(" ")
      }
      println()
    }
  }
  
  def balance(chars: List[Char]): Boolean={
    bal(chars,0)==0
  }
  
  def bal(chars: List[Char],count:Int):Int={
    if(chars.isEmpty || count<0) count
    else{
        chars.head match{
        case '('=>bal(chars.tail,count+1)
        case ')'=>bal(chars.tail,count-1)
        case _=>bal(chars.tail,count)
      }   
    }
  }
  
  def countChange(money: Int, coins: List[Int]): Int=change(money,coins,List[Int]()).length

  def change(money: Int, coins: List[Int], changes: List[Int]): List[List[Int]]={
    if(money==0) {
      return List[List[Int]](changes.sorted)
    }
    var sum=List[List[Int]]()
    for(i<-coins){
      if(money>=i){
        val tmp = change(money-i,coins,changes:::List(i))
        if(!tmp.isEmpty){
          if(sum.isEmpty) sum=tmp:::sum
          else{ // avoid duplicates
            for(t<-tmp) if(sum.filter(_==t).isEmpty) sum=t::sum      
          }
        }
      }
    }
    sum
  }
}
