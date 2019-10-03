package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

public interface IBaseModel {

    public abstract Long getId();

    public abstract void setId(Long id);

}
