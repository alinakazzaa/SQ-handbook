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

#### 

#### Future Plans

This is the functionality that will be added later, which will protect the user data and better. It is not essential for the moment as the tool is theoretically connected to other “caller” code, therefore the authentication is already happening in that platform. However, for extra measures and data protection purposes, this may be useful. 

![Future Plans](/resources/sprints/future.png)