#!/usr/bin/env groovy

//@Grab( 'com.bloidonia:groovy-stream:0.6.2' )
//@Grab(group='com.bloidonia', module='groovy-stream', version='0.8.1')
//import groovy.stream.Stream

import groovy.transform.*
//import groovy.transform.TailRecursive

def fib1(n) {
    if (n <= 1) return n

    def previous = n.valueOf(1), next = previous, sum
    (n-2).times {
        sum = previous
        previous = next
        next = sum + previous
    }
    next
}

def fib2(n) {
    if (n <= 1) return n
    fib(n - 1) + fib(n - 2)
}

@Memoized
def fib3(n) {
    if (n <= 1) return n
    fib(n - 1) + fib(n - 2)
}

// def fib(n) {
//     def zero = n.valueOf(0)
//     def one = n.valueOf(1)
//     Stream.iterate([zero, one], t -> [t[1], t.sum()])
//     .skip(n.longValue())
//     .findFirst().get()[0]
// }

println fib(10)
println fib(50L)
println fib(100G)

@TailRecursive
static fib4(n, a, b) {
    if (n == 0) return a
    if (n == 1) return b
    fib4(n - 1, b, a + b)
}

@TailRecursive
@CompileStatic
static fib5(Number n, Number a, Number b) {
    if (n == 0) return a
    if (n == 1) return b
    fib5(n - 1, b, a + b)
}

//println fib(10, 0, 1)
//println fib(50L, 0L, 1L)
//println fib(100G, 0G, 1G)
//println fib(500G, 0G, 1G)
