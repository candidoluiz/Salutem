package com.example.projeto;

public class LatLong {

     public static double distancia(double lat1, double long1, double lat2, double long2)
    {
        double rlat1 = Math.PI*lat1/180;
        double rlat2 = Math.PI*lat2/180;
        double theta = long1-long2;
        double rtheta = Math.PI*theta/180;
        double dist=Math.sin(rlat1)*Math.sin(rlat2)+Math.cos(rlat1)*
                Math.cos(rlat2)*Math.cos(rtheta);
        dist = Math.acos(dist);
        dist = dist*180/Math.PI;
        dist = dist*60*1.1515;
        return dist*1.609344;
    }
}
