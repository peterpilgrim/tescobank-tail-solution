# Tesco Bank - Exercise

## Exercise
Write a java program ( tale reader ) which is able to read a tale coming from a input text.
This java program should be able to read the text and produce an output text in any
format with:

 *  The total number of all words found in the text.
 *A table that order all words by the number of occurrences in the whole text for
example:

```
The : it has been found 82 times.

and : it has been found 55 times.

he: it has been found 43 times.

donkey : it has been found 19 times.

*&*TETS: it has been found 19 times.
```


Notes:

1. Words with special characters are consider different words.
For example: "king." "king's" "king. "king," can be seen as a different thing.
2. ( tale reader ) program is not key sensitive.



## Build Instruction

This is built with Gradle. 

Tested Junit and Hamcrest

Execute the sample program with the following command line arguments


Build the distribution

```
   $ gradle clean assemble test
```

Or 

```
   gradle build
```

Run the program with the script `run.sh`

```
    java -jar build/lib/DIST.jar  uk.co.xenonique.client.tescobank.TaleProcessorApp  src/test/resources/crawl.txt
```


Busy Java, microservices, application developer Peter Pilgrim, Sept 2018
 
*PP*

