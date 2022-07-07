package com.etc.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.DocumentDao;
import com.etc.model.Document;
import com.etc.service.DocumentService;


@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    @Override
    public int getDocumentListCount(Document document) {
        return documentDao.getDocumentListCount(document);
    }

    @Override
    public List<Document> getDocumentListByPage(Document document, Integer page, Integer limit) {
        //取出每一页的索引位置
        Integer start=(page-1)*limit;
        return documentDao.getDocumentListByPage(document,start,limit);
    }

    @Override
    public boolean addDocument(Document document) {
        if(documentDao.addDocument(document)>0){
            return true;
        }
        return false;
    }

    @Override
    public Document getDocumentById(Integer id) {
        return  documentDao.getDocumentById(id);
    }

    @Override
    @Transactional
    public boolean updateDocument(Document document) {
        if(documentDao.updateDocument(document)>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteDocument(String ids) {
        if(documentDao.deleteDocument(ids)>0){
            return true;
        }
        return false;
    }


}
