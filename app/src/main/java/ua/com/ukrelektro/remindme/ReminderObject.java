package ua.com.ukrelektro.remindme;

import java.util.Date;

/**
 * Created by User on 03.11.2015.
 */
public class ReminderObject {
    private String title;
    private String text;
    private Date date;
    private Tags tag;
    private Boolean status;

    ReminderObject(String title, Tags tag) {
        this.title = title;
        this.date = new Date();
        this.tag = tag;
        this.status = false;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tags getTag() {
        return tag;
    }

    public void setTag(Tags tag) {
        this.tag = tag;
    }


}
