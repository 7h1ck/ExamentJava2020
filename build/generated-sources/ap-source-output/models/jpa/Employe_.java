package models.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employe.class)
public abstract class Employe_ {

	public static volatile SingularAttribute<Employe, Date> dateEmbauche;
	public static volatile SingularAttribute<Employe, String> fullName;
	public static volatile SingularAttribute<Employe, Service> idService;
	public static volatile SingularAttribute<Employe, Integer> id;

}

