package rubiks
import java.util.PriorityQueue

data class Solution(val path: String, val score: Int)

class Search {
    private val cube: Cube
    private val compareByScore: Comparator<Solution> = compareBy { 0 - it.score }
    private val queue: PriorityQueue<Solution> = PriorityQueue<Solution>(compareByScore)

    public constructor(c: Cube){
        cube=c.clone()
    }

    public fun step(): Solution {
        val next = queue.remove()
        if( next.score == 54 ) return next

        for (i in "UuDdFfLlRrBb".toCharArray()){
            val path = next.path+i
            val e = Cube.scoreFaces(cube.clone().transform(path.toCharArray()))
            queue.offer(Solution(path, e))
        }
        return next
    }

    public fun search() {
        var cnt = 0
        queue.offer(Solution("", Cube.scoreFaces(cube)))
        do{
            val now = step()
            if(now.score == 54){
                println("Solution: " + now.path)
                break
            }

            cnt += 1
            /*
            if(cnt % 10==0){
                println("Last path: " + now.path)
                println("Last score: " + now.score)
            }*/
        }while(cnt<10000)
    }

    companion object {
        fun start(c:Cube): Search {
            return Search(c)
        }
    }

    /*
    I'll store Paths:
        queue = PriorityQueue< Tuple(score (more is more), String path) >

        step-function:
            next = queue.dequeue()
            for (i in "UuDdFfLlRrBb"){
                p = next.path + i
                e = Cube.scoreFaces(c.clone().transform(p))
                queue.enqueue(Tuple(
            }

    Hm, of course - giving a start "near" the correct solution, it ends up in a local optimum.
    - Need a different cost function
    - Maybe something estimating "distance". How far is each face from it's

    *
     */
}