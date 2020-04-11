package ru.volnenko.se.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author Denis Volnenko
 */

public final class Project implements Serializable {

    private String id = UUID.randomUUID().toString();

    private String name = "";

    private Date dateBegin;

    private Date dateEnd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

}
