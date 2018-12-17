# OneView_Alerts

 https://stackoverflow.com/questions/53823128/initialize-sqlite-cursor-before-accessing-data-from-it

I am trying to insert data into a SQLite DB once a notification is received via FCM. For debugging purpose I am also inserting a dummy data into my DB when SHow Token is clicked on the HomeScreen activity.

However am getting "Make sure the cursor is initialized correctly before accessing data from it" error.

Link to my code: - GitHub

Can someone please go through my code and let me know where I am going wrong.

Note - I added below in HomeScreen.java,MyFirebaseMessagingService.java and NotificationDetails.java

private SQLiteDB dbHelper = new SQLiteDB(this);
since the suggested
private SQLiteDB dbHelper;

When I used above I kept on getting Nullpointer exception, so I figured since the SQLiteDB class constructor is accepting a context, so let me pass one, post which I did not get NullPointer Exception.

Now I did this without being fully aware of the concept on context which I have been trying to wrap my head around, but since am an extreme noob to android I am not able to grasp it just yet. I suspect it might have something to do with the context I am passing.

Can someone please help me here with detailed instructions on how to fix this issue, I have been through many other threads on this but was not able to fix hence after 5 hrs of going through multiple SO questions, I am posting this one.

Thanks in advance to everyone in the community for the help. :)
