package beans;

import util.Log;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gabri on 2016-06-09.
 */

@Stateless(name = "SearchEJB")
public class SearchBean implements Serializable{

    @Inject
    private SessionBean sessionBean;

    private String name = "";

    public SearchBean() {
        if(sessionBean == null) {
            sessionBean = new SessionBean();
        }
    }

    @PostConstruct
    void init() {
        Log.info("sessionBean = " + sessionBean);
    }

    public void setName(String name) {
        try {
            sessionBean.insertArtist(name);
        } catch (NullPointerException e) {
            throw new NullPointerException(Math.random() + ": SessionBean = " + sessionBean + " name = [" + name + "]\n" + e.toString());
        }
        this.name = name;
    }

    public String getName() {
        List results = sessionBean.selectArtist(name);
        for (Object s: results) {
            System.out.println(s.toString());
        }
        return results.toString();
    }
}
