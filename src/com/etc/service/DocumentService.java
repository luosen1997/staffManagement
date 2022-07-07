package com.etc.service;

import java.util.List;

import com.etc.model.Document;

public interface DocumentService {
	
    public int getDocumentListCount(Document document);

    public List<Document> getDocumentListByPage(Document document, Integer page, Integer limit);

    public boolean addDocument(Document document);

    public Document getDocumentById(Integer id);

    public boolean updateDocument(Document document);

    public boolean deleteDocument(String ids);
}
