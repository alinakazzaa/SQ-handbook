# Handbook for Best Practices

## Sample Survey Component

This handbook is a reference guide to demonstrate the approach to project management within the organization. Here you will find process guidelines for planning, such as:

* Sprint task estimation
* Description of tasks
* Task prioritization using the MoSCoW (Must, Should, Could, Won't) technique
* Identify the users of the software i.e. surveyor and surveyed and the functionality each of them have

### Scrum sprint backlog and task estimation

The software component will consist of functionality to create a survey and receive answers to this survey. Therefore, the ‘surveyor’ and the ‘surveyed’ roles will be associated with the specific tasks. 

Tasks will be done in 'sprints' or development stages, which will be timed and each task will receive an estimation of completion time. 

To estimate the amount of time it will take to do and the complexity of the task. To allocate story points, a Fibonacci sequence will be used i.e. 1, 2, 3, 5, 8, 13. 

Note: development time of this sample software will be much shorter than real life tools, however it will help to describe the process of the Scrum backlog, which will be customized to each product. One story point for this sample project will be estimated at 10 minutes. 

#### Sprint 1

This sprint will focus on the surveyor functionality, as to begin the process of receiving answers to surveys will depend on the existence of these “must have” features. 

![Sprint 1](/resources/sprints/1.png)

To begin the project, I will create survey objects that will be required such as Survey, Question and Response. Each object will have a set of attributes. This initial set up will take long, therefore 40 minutes is allocated to it. 

To view the already existing projects, 20 minutes is sufficient enough. However, the overall spring time is the longest as it will contain the core functionality of the system. 

#### Sprint 2

In the second sprint it the functionality for the surveyed person (answering the survey) will be added. This relies on the completion of the tasks in the first spring, therefore will be done after. The ability to see all survey responses by the surveyor is not a core functionality to be able to implement the survey processes, however, it is the purpose of a survey in the first place, therefore is considered a core or “must have” functionality. 

![Sprint 2](/resources/sprints/2.png)

#### Sprint 3

Spring three will focus on providing statistics of the survey and will calculate the average, standard deviation, minimum and maximum score of the overall responses received in all question responses.

![Sprint 3](/resources/sprints/3.png)

#### Sprint 4

This sprint will be the extension of the statistics feature to gain deeper insight into individual response score of the survey questions, which will provide average, standard deviation, minimum and maximum score of each question’s responses. 

![Sprint 4](/resources/sprints/4.png)

#### Future Plans

This is the functionality that will be added later, which will protect the user data and better. It is not essential for the moment as the tool is theoretically connected to other “caller” code, therefore the authentication is already happening in that platform. However, for extra measures and data protection purposes, this may be useful. 

![Future Plans](/resources/sprints/future.png)

### Test Driven Development

To ensure code is consistent and to minimise bugs, each piece of functionality must be tested before code is written using this functionality. 

To define TDD, follow these steps:

1. Add a test for piece of functionality
2. Run test and see if it fails
3. Refactor code & re-run
4. If passes, implement functionality

Code must be refactored until the point of error free execution. See diagram below for a representation of the TDD flow:

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

3. Run test and if fails, refactor, otherwise write more tests. 

![Run Test](/resources/diagrams/run-test.png)

Here is an example of a passed test:

![Passed Test](/resources/diagrams/passed-test.png)

And a failed test, which describes exactly where it is failing, with reference to the line of code, therefore it is easy to spot the mistakes and fixed them instantly:

![Failed Test](/resources/diagrams/failed-test.png)

### Team Version Control

To ensure code is delivered consistently and is easy to navigate and trace, it is essential to split the functionality and implement them usiing feature branches. 

Initially, one must always use the develop branch created locally. Each new functionality to be added to the software will get its own branch and be merged into the develop branch. 

Once all code is tested and approved by reviewer(s), it will be merged into the master branch and released into production. 

The following GitFlow procedures must be followed:

1. Fork working repository to own repository & clone to local storage

`git clone <repo-link>`

2. Create develop branch locally

`git checkout -b develop`

3. Create feature branch originating from develop

`git checkout develop` + 
`git checkout -b <feature-branch>`

4. Write code, review & approve

[Sample approval](https://github.com/alinakazzaa/SQ-handbook/pull/2#issuecomment-629871156)

5. Merge into develop branch and pull

`git checkout develop` + 
`git merge <feature-branch>`

resolve merge conflicts if any

`git push`
`git pull origin develop`

6. Use hotfix branch for any force major code amendments

`git checkout develop`
`git checkout -b hotfix-1.0.1`

and follow same merge process as above

7. Create release branch originating from develop branch and update software version

`git checkout develop`
`git checkout -b release-1.0.1`

8. Merge release branch with master

`git checkout master`
`git merge --no-ff release-1.0.1`
`git push`


5. Include a section in your documentation on Code Reviews

6. Suggest a checklist of things that a reviewer should check when reviewing a Pull Request

7. Link to a closed Pull Request within your project that demonstrates this list was followed 

8. Explain how the Velocity metric is calculated at the end of each sprint, and how that feeds into planning for the next Sprint