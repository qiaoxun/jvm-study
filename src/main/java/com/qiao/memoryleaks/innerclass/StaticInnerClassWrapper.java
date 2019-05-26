package com.qiao.memoryleaks.innerclass;

import java.lang.ref.WeakReference;

public class StaticInnerClassWrapper {
    private BulkyObject bulkyObject = new BulkyObject();

    public static class SimpleInnerClass {
        private WeakReference<StaticInnerClassWrapper> innerClassWrapperWeakReference;

        public SimpleInnerClass(StaticInnerClassWrapper innerClassWrapper) {
            innerClassWrapperWeakReference = new WeakReference<>(innerClassWrapper);
        }

        public void loopBulky() {
            StaticInnerClassWrapper innerClassWrapper = innerClassWrapperWeakReference.get();
            if (null != innerClassWrapper) {
                System.out.println(innerClassWrapper.getBulkyObject());
            }
        }
    }

    public BulkyObject getBulkyObject() {
        return this.bulkyObject;
    }
}
