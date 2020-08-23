let arr1 = ["A","AA","AAA","AAAA"]
let arr2 = ["B","BB","BBB","BBBB","BBBBB","B"]
var arr3 = [69, 420];


arr1.concat(arr2)
/*
[
    'A',     'AA',
    'AAA',   'AAAA',
    'B',     'BB',
    'BBB',   'BBBB',
    'BBBBB', 'B'
  ]
  */
arr1.every((value) =>{return value.includes('A')})
// true

arr2.filter((value) => {return value.length > 3})
// [ 'BBBB', 'BBBBB' ]

arr2.forEach((value) => {console.log(value)})
/*
B
BB
BBB
BBBB
BBBBB
B
*/

arr2.indexOf("BB")
// 1

arr2.join()
// 'B,BB,BBB,BBBB,BBBBB,B'

arr2.lastIndexOf("B")
// 5

arr2.map((value) => {return value.length})
// [ 1, 2, 3, 4, 5, 1 ]

console.log(arr2.pop())
// 'B'

arr2.push("C")
// 6

arr3.reduce((a,b) => { return a-b})
// -351

arr3.reduceRight((a,b) => {return a-b})
// -200

arr3.reverse()
// [ 420, 69 ]

arr3.shift()
//420

arr3.unshift(420)
// 2


arr3.slice(0,1)
// [ 420 ]

arr3.some((value) => {return (value>100)})
// true

arr3.sort())
// [ 420, 69 ]

arr3.splice(2, 0, 11,121)
// [ 420, 69, 11, 121 ]

arr3.toString()
// '420,69,11,121'



//Regex Methods

var str = "Javascript is the most widely used programming language"
var pat = new RegExp("is")
pat.exec(str)
/*
 [
  'is',
  index: 11,
  input: 'Javascript is the most widely used programming language',
  groups: undefined
]
*/

pat.test(str)
// true

str.match(/is/)
/*
[
    'is',
    index: 11,
    input: 'Javascript is the most widely used programming language',
    groups: undefined
  ]
  */

str.search("was")
// -1

str.replace("is","was")
// Javascript was the most widely used programming language

str.split(" ")
/*
 [
  'Javascript',
  'is',
  'the',
  'most',
  'widely',
  'used',
  'programming',
  'language'
]
*/