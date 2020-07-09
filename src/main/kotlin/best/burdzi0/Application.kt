package best.burdzi0

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("best.burdzi0")
		.start()
}

