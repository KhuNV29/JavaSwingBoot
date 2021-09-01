package poly.store.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ReportAccount {
	@Id
	String username;
	String fullname;
	String email;
	long countAccount;
}
