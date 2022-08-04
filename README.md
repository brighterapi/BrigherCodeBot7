
BrigherCodeBot7 - Twitter Bot which Retweet #365DaysOfCode 

# Hi, I'm Milind Mehta! 👋


## 🚀 About Me
I'm a Java-Spring boot Microservice developer. who works with banking applications.



## Features


## Features

- Twitter Retweet Ready-made Bot

BrigherCodeBot7 is a Twitter retweet bot currently powering my accounts @brighterapi
It retweets everything the search finds. It is intended to be used with searches like #365dayaofcode so that everyone can at-mention the account [@CodingBot7](https://twitter.com/CodingBot7) and will get a retweet, thus reach every follower of [milindmehtamca](https://twitter.com/milindmehtamca).
The bot's own Twitter account can be found at [@CodingBot7](https://twitter.com/CodingBot7).


## Tech Stack
**Server:** Java, Maven, Spring boot

For some calls it still relies on the deprecated Twitter API 1.1. 
For calls to this API it uses Twitter4J, which does not seem to be maintained anymore as well. 
For other calls, and especially the calls that actually search for new tweets, it already relies on the new Twitter API 2.0 to which I got early access. These calls are made without any library help. Further migration will happen over time.


## Run Locally

Clone the project

```bash
  git clone https://github.com/brighterapi/BrigherCodeBot7
```

Go to the project directory

```bash
  mvn clean install
```

Start the server

```bash
  mvn spring-boot:run
```


## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/milindmehtamca/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/milindmehtamca)

