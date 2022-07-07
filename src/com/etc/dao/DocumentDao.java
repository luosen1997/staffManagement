package com.etc.dao;

import org.apache.ibatis.annotations.Param;

import com.etc.model.Document;

import java.util.List;


public interface DocumentDao {
    public int getDocumentListCount(Document document);

    public List<Document> getDocumentListByPage(@Param("document") Document document, @Param("start") Integer start,@Param("limit") Integer limit);

    public int addDocument(Document document);

    public Document getDocumentById(Integer id);

    public int updateDocument(Document document);

    public int deleteDocument(@Param("ids") String ids);
}
