package com.qiao.service;

import com.qiao.dao.MemoryLeakTestDao;

public class MemoryLeakTestService {
    public void testMemoryLeak() {
        MemoryLeakTestDao dao = new MemoryLeakTestDao();
        dao.addDataToList();
    }

    public void testStaticList() {
        MemoryLeakTestDao dao = new MemoryLeakTestDao();
        dao.setStaticTestList();
    }
}
