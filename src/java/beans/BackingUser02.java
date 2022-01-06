package beans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.*;

@Named
@ViewScoped
public class BackingUser02 implements Serializable {

    @NotNull
    private String id;
    private String name;
    private String zipcode;
    private String address;

    @EJB
    UserWorker02 wk;
    @Inject
    transient Logger log;

    public String register() {
        UserEntity02 entity = new UserEntity02(id, name, zipcode,address);
        try {
            wk.register(entity);
            clear();
        } catch (Exception e) {
            log.log(Level.SEVERE, "ID{0}を登録できません", id);
        }
        return null;
    }

    public void clear() {
        id = name = zipcode = address = null;
    }

    public List<UserEntity02> getData() {
        return wk.getData();
    }

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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

