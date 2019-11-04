package pl.poznan.put.cie.coffee;

import javax.persistence.*;

@Entity
@Table(name = "COFFEE_DESCRIPTIONS", schema = "dbo", catalog = "Coffees")
public class CoffeeDescriptionsEntity {
    private String cofName;
    private String cofDesc;

    @Id
    @Column(name = "COF_NAME")
    public String getCofName() {
        return cofName;
    }

    public void setCofName(String cofName) {
        this.cofName = cofName;
    }

    @Basic
    @Column(name = "COF_DESC")
    public String getCofDesc() {
        return cofDesc;
    }

    public void setCofDesc(String cofDesc) {
        this.cofDesc = cofDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeeDescriptionsEntity that = (CoffeeDescriptionsEntity) o;

        if (cofName != null ? !cofName.equals(that.cofName) : that.cofName != null) return false;
        if (cofDesc != null ? !cofDesc.equals(that.cofDesc) : that.cofDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cofName != null ? cofName.hashCode() : 0;
        result = 31 * result + (cofDesc != null ? cofDesc.hashCode() : 0);
        return result;
    }
}
