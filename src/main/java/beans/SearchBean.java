package beans;

import util.Log;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gabri on 2016-06-09.
 */

@Stateful(name = "SearchEJB")
public class SearchBean implements Serializable{

    @Inject
    private SessionBean sessionBean;

    private String name = "";

    public SearchBean() {
        if(sessionBean == null) {
            sessionBean = new SessionBean();
            Log.info("Created sessionBean!", this);
        }
    }

    @PostConstruct
    void init() {
        Log.info("sessionBean = " + sessionBean, this);
    }

    public void setName(String name) {
        Log.info("setName: name = " + name, this);
        try {
            sessionBean.insertArtist(name);
        } catch (NullPointerException e) {
            throw new NullPointerException(Math.random() + ": SessionBean = " + sessionBean + " " + e.toString());
        }
        this.name = name;
    }

    public String getName() {
        Log.info("setName: getName = " + name, this);
        List results = sessionBean.selectArtist(name);
        for (Object s: results) {
            System.out.println(s.toString());
        }
        return results.toString();
    }
}
