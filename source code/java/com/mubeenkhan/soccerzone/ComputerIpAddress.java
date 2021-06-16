package com.mubeenkhan.soccerzone;

public class ComputerIpAddress {
    public static final String localIP = "192.168.100.10";

    /*public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if(!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        Log.e("wwww", inetAddress.getHostAddress().trim());
                        return inetAddress.getHostAddress().trim();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("wwww", ex.toString());
        }
        return "";
    }*/
}
