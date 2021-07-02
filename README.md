# Simple-Notes-Application
Final Project for INFOTC 3330

My JavaFX application is a note-taking application. The design of the application is meant to resemble that of a traditional notepad. The dark yellow top bar of the application is similar to the binding that holds the pages together. The antique, off-white color of the body represents the pages. I think these colors allow the application to look attractive to the user, as well as hint towards the traditional methods of notetaking. Lastly, I chose an attractive, serif-style font for the application, which I felt worked much better for the aesthetic I was going for over the default font. The application is basic, but very functional. Users can give their note a title. This allows users to keep the notes they create specific and functional, or they can keep it generic and use one note for all their note-taking needs. Additionally, instead of just implementing a simple text editor, I decided to give the user options for how the note should look. They can choose font styles, sizes, and whether it’s bold or italic. They can even make bulleted lists and justify the text however they see fit. The application managed to accomplish all this, while still staying minimalist in nature. The user also has the option to save notes and open those notes later. The application also has an ‘About’ page, where the user can learn more about the application itself as well as the code that was used to create it. 

Requirements:

1.	Object oriented elements:
a.	Classes: there are several classes in my program. These classes include: NotesModel, AboutPageController, NotesPageController, Note, and a couple others as well.
b.	Subclasses: the NotesModel class is a great example of a subclass in my application. It extends the AbstractModel class so that the application can utilize proper MVC architecture. 
c.	Abstract Class: the abstract class that my application uses is the AbstractModel class. This class allows the application to utilize MVC architecture.
d.	Interface: the interface that my application uses is the Serializable interface. This interface allows my program to save/load data, and my application uses it frequently.
2.	Code elements:
a.	Collections: Unfortunately, my application does not include a collection. I ran out of time to properly implement a collection in a meaningful way, so I decided to omit it from the final product in favor of keeping the application/code functional and intentional.
b.	Exception Handling: There are several instances of exception handling in my program. 
i.	NotesModel -> lines 38-59, lines 70-85.When opening a note that the user has previously saved, it checks for any error that may occur and displays an alert notifying the user of the error. For example, if a user tries to open a png using the Notes app, they will be met with an error. But if a user tries to open a note that they have created using this application, it will work just fine. The application also error checks during the saving process in a similar fashion. If a FileNotFoundException or IOException occurs, the user will be notified.
3.	Clearly defined model: in this application, the NotesModel is the clearly defined model. It performs all of the calculations and functions, but it does not interact with the view directly, only the controller.
4.	Multiple Scenes:
a.	Dynamic Scene: the Notes page is one of the two scenes in this application. This one is dynamic in that it changes as the user interacts with the application. 
b.	Static Scene: the static scene in this application is the ‘About’ page. It does not change no matter what the user does with the application, so it is static in nature.
5.	‘About’ information: there is a dedicated scene in this application for displaying information about the application to the user. It is accessed by going to Help -> About.
6.	Save/Load Data: this application relies heavily on saving and loading information. When a user writes a new note, they can save that note and load it back into the application later on. 
a.	NotesModel -> handleOpen(File file), handleSave(File file)

Expectations:

1.	Functional Application: this application has a particular function in mind. It was not created just to satisfy a list of requirements, but to perform a useful service to the user. It allows the user to create notes and save/load them. Whether it’s a to-do list, shopping list, or even an essay, all of it can be done with the application.
2.	Good UI: The UI is uncomplicated and easy to use. I tried to make the appearance of the application attractive and reminiscent of traditional note-taking methods. I also did not load the application with unnecessary functions that would only confuse the user or make it bloated and distracting. I feel as though I accomplished this well.
3.	Well-structured and organized code: I spent a considerable amount of time working with the organization of the code. Organizing the code into MVC architecture was a challenge, but the finished product is well-organized and functional. Additionally, I tried to separate my code into methods as often as I thought appropriate so that one method wouldn’t be overly long. The methods I did write are organized and grouped together in a logical way. The displayExceptionAlert and displayErrorAlert functions are kept together because they function similarly. I also kept the handleOpen and handleSave functions close together because they are in the menu bar. Little things like these helped make the code organized and well thought out, instead of a scrambled mess. 
4.	Purposeful application: this application is indeed purposeful. As I mentioned above, it is not meant just to satisfy a list of requirements, but to function and provide a service to the user. I spent time deciding on what kind of application I wanted to develop, how I wanted it to look, etc.
5.	Happy to Show Employer: I would be happy to show this application to an employer. Sure, it’s not as beautifully designed as Apple’s Notes application, but I believe that it showcases my abilities with the Java language well, and it demonstrates that I can design an application that not only looks good, but is functional as well. 
