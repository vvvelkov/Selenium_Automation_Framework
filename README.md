# Selenium_Automation_Framework

This is a Selenium Automation Framework Project based on TestNG and Selenium WebDriver technologies. The framework deals with the website http://training.skillo-bg.com:4200.

## Build System

The entire project is built on Maven. The exact version is http://maven.apache.org/POM/4.0.0

All tests can be run with the command:

```bash
mvn clean test
```

## Usage

```java
// Login with existing profile credentials 
LoginTest.testLogin(user, password)

// Like posts, follow users from the Home Page
HomePageInteractionsTest.testHomePage(email, password)

// Open/close post, like/dislike post, follow/unfollow from User Page 
UserPageInteractionsTest.testUserPage(email, password)

// Create a new post
CreatePostTest.testNewPost(caption, email, password, postImage)

// Change post status and delete post from Profile Page
ProfileInteractionsTest.testProfileInteractions(email, password, name)
```

## How to Contribute

1. Clone repo and create a new branch: $ git checkout https://github.com/vvvelkov/Selenium_Automation_Framework -b name_for_new_branch.
2. Make changes and test
3. Submit Pull Request with comprehensive description of changes
