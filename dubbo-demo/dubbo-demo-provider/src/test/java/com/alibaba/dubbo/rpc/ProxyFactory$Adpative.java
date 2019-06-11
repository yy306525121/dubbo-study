package com.alibaba.dubbo.rpc;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class ProxyFactory$Adpative implements ProxyFactory {
    public Object getProxy(Invoker invoker) throws com.alibaba.dubbo.rpc.RpcException {
        if (invoker == null) {
            throw new IllegalArgumentException("com.alibaba.dubbo.rpc.Invoker argument == null");
        }

        if (invoker.getUrl() == null) {
            throw new IllegalArgumentException("com.alibaba.dubbo.rpc.Invoker argument getUrl() == null");
        }

        URL url = invoker.getUrl();

        String extName = url.getParameter("proxy", "javassist");

        if (extName == null) {
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.rpc.ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        }

        ProxyFactory extension = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getProxy(invoker);
    }

    public Invoker getInvoker(Object object, Class clazz, URL url) throws RpcException {
        if (url == null) {
            throw new IllegalArgumentException("url == null");
        }

        String extName = url.getParameter("proxy", "javassist");

        if (extName == null) {
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.rpc.ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        }

        ProxyFactory extension = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getInvoker(object, clazz, url);
    }
}
