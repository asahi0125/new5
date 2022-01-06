package beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@SecondaryTables({
    @SecondaryTable(name = "zipcode_tbl"),
    @SecondaryTable(name = "address_tbl"),
})
@Table(name="user_data_2")
public class UserEntity02 implements Serializable {
	@Id @NotNull
    private String id;
    private String name;
    @Column(table = "zipcode_tbl")
    private String zipcode;
    @Column(table = "address_tbl")
    private String address;

    public UserEntity02() {
    }

    public UserEntity02(
            String id, String name, String zipcode, String address){
        this.id = id;
        this.name = name;
        this.zipcode = zipcode;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getAddress() {
        return address;
    }
}

