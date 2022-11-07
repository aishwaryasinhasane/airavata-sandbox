package com.smiles;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;

public class MoleculeJSON {

  private final List<Document> moleculeList;

  private MoleculeJSON(List<Document> moleculeList) {
    this.moleculeList = moleculeList;
  }

	public static MoleculeJSON of(List<Document> moleculeList) {
		return new MoleculeJSON(moleculeList);
	}
  
	public String toJsonString() {
		return moleculeList.stream()
		.limit(50)
		.map(m -> m.toJson())
		.collect(Collectors.joining(",", "{\"data\": [", "]}"));
  }
}
