# DancingLinks
This project is a Java implementation of Knuth's [DancingLinks](http://arxiv.org/pdf/cs/0011047v1.pdf) algorithm and its application to exact cover problems.

## How-to
- After downloading the source files compile them with:  

  ```
  cd src  
  javac *.java
  ```

- Run it with,
  - for matrix covering:
    - ``` java -ea Main emc```
    - the program then reads a problem from the standard input in the form:  

      >number of primary columns  
      >number of secondary columns  
      >number of lines  
      >line 1  
      >line 2  
      >...  

    - the program then prints the number of solutions.  
  - for covering problems like pentominoes:
    - ```java -ea Main pavage```
    - the program then reads a problem from the standard input in the form:  

      >number of columns  
      number of lines  
      line 1  
      line 2  
      ...  
      number of pieces  
      piece 1  
      piece 2
      ...  

        each piece is described by many lines, in the form:  

      > number of columns  
      number of lines  
      line 1  
      ...  

        where each line codes a significative case with an * or a non significative with any other.
