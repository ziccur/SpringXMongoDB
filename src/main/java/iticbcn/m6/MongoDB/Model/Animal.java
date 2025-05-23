package iticbcn.m6.MongoDB.Model;

import java.io.Serializable;

import org.mapstruct.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Animal")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Animal implements Serializable {
	@Id
	private String id;
	private String nom;
	private int edat;
}
