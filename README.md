# Handbook for Best Practices

## Sample Survey Component

This handbook is a reference guide to demonstrate the approach to project management within the organization. Here you will find process guidelines for planning, such as:

* Sprint task estimation
* Description of tasks
* Task prioritization using the MoSCoW (Must, Should, Could, Won't) technique
* Identify the users of the software i.e. surveyor and surveyed and the functionality each of them has

### Scrum sprint backlog and task estimation

The software component will consist of functionality to create a survey and receive answers to this survey. Therefore, the ‘surveyor’ and the ‘surveyed’ roles will be associated with specific tasks. 

Tasks will be done in 'sprints' or development stages, which will be timed and each task will receive an estimation of completion time. 

To estimate the amount of time it will take to do and the complexity of the task. To allocate story points, a Fibonacci sequence will be used i.e. 1, 2, 3, 5, 8, 13. 

Note: development time of this sample software will be much shorter than real-life tools, however, it will help to describe the process of the Scrum backlog, which will be customized to each product. One story point for this sample project will be estimated at 10 minutes. 

#### Sprint 1

This sprint will focus on the surveyor functionality, as to begin the process of receiving answers to surveys will depend on the existence of these “must-have” features. 

![Sprint 1](/resources/sprints/1.png)

A total Velocity of 9 story points during the first spring sets the pace of development for the remainder of the project. 

During this sprint, the team can assess the complexity of the software and estimate the time it will take to continue adding new functionality. The goal is to maintain this workflow (given the time taken to achieve functionality is in accordance with the expectations) and add/ remove sprint tasks to maintain a balanced burndown. 

To begin the project, I will create survey objects that will be required such as Survey, Question and Response. Each object will have a set of attributes. This initial set up will take long, therefore 40 minutes is allocated to it. 

To view the already existing projects, 20 minutes is sufficient enough. However, the overall sprint time is the longest as it will contain the core functionality of the system. 

#### Sprint 2

In the second sprint, it the functionality for the surveyed person (answering the survey) will be added. This relies on the completion of the tasks in the first spring, therefore will be done after. The ability to see all survey responses by the surveyor is not a core functionality to be able to implement the survey processes, however, it is the purpose of a survey in the first place, therefore is considered a core or “must-have” functionality. 

![Sprint 2](/resources/sprints/2.png)

The total velocity of this sprint is almost equal to the first one but is 1 story points less. This is acceptable and is within the steady workflow, however, is less than the first sprint, which means either less work had to be done or it was less complex.

#### Sprint 3

Spring three will focus on providing statistics of the survey and will calculate the average, standard deviation, minimum and maximum score of the overall responses received in all question responses.

![Sprint 3](/resources/sprints/3.png)

A maintained total of 8 story points during the third sprint indicates that work has been split evenly and sprint tasks' complexity and time consumption were identical to the previous. 

#### Sprint 4

This sprint will be the extension of the statistics feature to gain deeper insight into individual response score of the survey questions, which will provide average, standard deviation, minimum and maximum score of each question’s responses. 

![Sprint 4](/resources/sprints/4.png)

Similarly to the previous 2 sprints, this was accurately estimated. 

#### Future Plans

This is the functionality that will be added later, which will protect the user data and better. It is not essential for the moment as the tool is theoretically connected to other “caller” code, therefore the authentication is already happening in that platform. However, for extra measures and data protection purposes, this may be useful. 

![Future Plans](/resources/sprints/future.png)

### Test Driven Development

To ensure code is consistent and to minimise bugs, each piece of functionality must be tested before code is written using this functionality. 

To define TDD, follow these steps:

1. Add a test for a piece of functionality
2. Run the test and see if it fails
3. Refactor code & re-run
4. If passes, implement functionality

Code must be refactored until the point of error-free execution. See the diagram below for a representation of the TDD flow:

![TDD How to](/resources/diagrams/tdd-diagram.png)

For example, here is a JUnit test for the functionality to get the average score of all survey questions: 

 [PR 5 commit - test get average of survey scores](https://github.com/alinakazzaa/SQ-handbook/pull/5/commits/a3a955f7cf11ab4372f5ef57b22bb9ab122d41cf)

There is a function called testGetSurveyAverage(), which is a test for the functionality of [getSurveyAverage()](https://github.com/alinakazzaa/SQ-handbook/pull/5/commits/b3ccab91a1c481efe58aad64b3147d7144d4e834) and tests the function using test data. This test was passed, and therefore the functionality was implemented.

#### Code Coverage Tool: Java JUnit

In this example project, using JUnit testing provided by Java, which is a tool that allows automated testing by assertion or pass/fail. To implement a JUnit test using Eclipse:

1. Create a JUnit Test Case

![Add JUnit Test Case](/resources/diagrams/add-junit.png)

2. Write test case using @Test annotation (which tells Java that this is an automated JUnit test)

![Test Annotation](/resources/diagrams/test-annot.png)

3. Run the test and if fails, refactor, otherwise write more tests. 

![Run Test](/resources/diagrams/run-test.png)

Here is an example of a passed test:

![Passed Test](/resources/diagrams/passed-test.png)

And a failed test, which describes exactly where it is failing, with reference to the line of code, therefore it is easy to spot the mistakes and fixed them instantly:

![Failed Test](/resources/diagrams/failed-test.png)

### Team Version Control

To ensure code is delivered consistently and is easy to navigate and trace, it is essential to split the functionality and implement them using feature branches. 

Initially, one must always use the develop branch created locally. Each new functionality to be added to the software will get its own branch and be merged into the develop branch. 

Once all code is tested and approved by the reviewer(s), it will be merged into the master branch and released into production. 

The following GitFlow procedures must be followed:

1. Fork working repository to own repository & clone to local storage

`git clone <repo-link>`

2. Create develop branch locally

`git checkout -b develop`

3. Create a feature branch originating from develop branch

`git checkout develop   git checkout -b <feature-branch>`

4. Write code, review & approve

[Sample approval](https://github.com/alinakazzaa/SQ-handbook/pull/2#issuecomment-629871156)

5. Merge into develop branch and pull

`git checkout develop   git merge <feature-branch>`

resolve merge conflicts if any

`git push  git pull origin develop`

6. Use hotfix branch for any force major code amendments

`git checkout develop   git checkout -b hotfix-1.0.1`

and follow the same merge process as above

7. Create release branch originating from develop branch and update software version

`git checkout develop   checkout -b release-1.0.1`

8. Merge release branch with master

`git checkout master   git merge --no-ff release-1.0.1<br/>git push`


### Code Reviews

Code reviews are an essential part of team development which encourages bug spotting, teamwork and a mix of opinions on implementation, and with the power of 'group think' helps overcome barriers, spot bugs and missing functionality, as well as encourage learning and improvement by providing feedback. 

Each pull request with new functionality will be reviewed by one or several members of the team, feedback will be given and changes suggested. These changes will be implemented by the developer and again undergo a review. Once no more changes are requested, the pull request will be merged into production.

#### Sample Code Review Checklist

- [x] Clarity: understandable, well laid out and easy to navigate code
- [x] Less is more: no excess unnecessary code to achieve functionality is written
- [x] Duplication: no duplicated code - if duplication occurs, code should be further split into classes/ methods
- [x] Testing: all functionality has executed passing tests

In the sample project, I have demonstrated sample review processes for the following: 

- [x] [Clarity](https://github.com/alinakazzaa/SQ-handbook/pull/2/files) 

Code is well-formatted, therefore is easy to read. All functionality is split into single methods with one specific functionality, which is easy to navigate, re-use and change in the future. 

- [x] [Less is more & duplication](https://github.com/alinakazzaa/SQ-handbook/pull/7/files)

Here I have left negative feedback, pointing out that code duplication is poor practice and repeating code should be put into a reusable function. In this case, code should be refactored and submitted again for the review. 

- [x] [Testing](https://github.com/alinakazzaa/SQ-handbook/pull/7/files)

Here the test cases use randomly generated data (instead of writing more code to hardcode values), therefore it is impossible to compare an asserted value not knowing the outcome of the randomly generated numbers. However, for better practices, it is better to have a legitimate hardcoded value that is sure to compare easily with the tested function outcome. 