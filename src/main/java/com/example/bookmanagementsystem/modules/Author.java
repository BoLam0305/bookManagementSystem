package com.example.bookmanagementsystem.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<Book> books;

	@Override
	public String toString() {
		return "Author{" +
			"id=" + id +
			", name='" + name + '\'';
	}
}
