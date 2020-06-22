package com.atguigu.bigdata.scala
import scala.collection.immutable
/**
 * @author ygCode
 * @create 2020-05-28 14:59
 */
object Homework {

  def main(args: Array[String]): Unit = {
    val tuples: List[(String, Int)] = List(
      ("hello", 4),
      ("hello spark", 3),
      ("hello spark scala", 2),
      ("hello spark scala hive", 1)
    )
    val list: List[immutable.IndexedSeq[String]] = tuples.map(kv => for (k <- 1 to kv._2) yield {
      kv._1
    })
    //将其全部打散
    val flatten = list.flatten
    println(flatten)
    val list1 = flatten.flatMap(word => word.split(" "))
    println(list1)
    //将打散后的数据分组
    val wordmap = list1.groupBy(word => word)
    println(wordmap)
    //将元组变为元素，个数的形式
    val maplist = wordmap.map(word => (word._1,word._2.length))
    println(maplist)
    //将元祖个数由大到小排序，取前三
    val list2 = maplist.toList.sortBy(kv =>kv._2)(Ordering.Int.reverse)
    val list3 = list2.take(3)
    //打印最后结果
    println(list3)

  }
}