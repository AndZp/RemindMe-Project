package ua.com.ukrelektro.remindme.utils;

import java.util.ArrayList;

import ua.com.ukrelektro.remindme.R;
import ua.com.ukrelektro.remindme.models.ReminderObject;
import ua.com.ukrelektro.remindme.models.Tags;

public class InitUtil {

    public static String getUserName() {
        return "Andrey Oleynik";
    }

    public static String getEmail() {
        return "andrey.oleynik.zp@gmail.com";
    }

    public static int getIcon() {

        return R.drawable.account_circle;
    }

    public static ArrayList<ReminderObject> initData() {
        ArrayList<ReminderObject> reminderObjects = new ArrayList<>();
        reminderObjects.add(new ReminderObject("Do cool app", Tags.Work));
        reminderObjects.add(new ReminderObject("Go to Bar", Tags.Rest));
        reminderObjects.add(new ReminderObject("Learn all Android SDK", Tags.Learn));
        reminderObjects.add(new ReminderObject("My birthday", Tags.BirthDay));
        reminderObjects.get(2).setStatus(true);
        reminderObjects.get(3).setStatus(true);
        reminderObjects.add(new ReminderObject("Find job", Tags.Work));
        reminderObjects.add(new ReminderObject("Go to Bar again", Tags.Rest));
        reminderObjects.add(new ReminderObject("Learn all C#", Tags.Learn));
        reminderObjects.add(new ReminderObject("My birthday", Tags.BirthDay));
        return reminderObjects;
    }
}
