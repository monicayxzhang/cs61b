public class NBody {

  public static double readRadius(String FileName) {
    In in = new In(FileName);
    in.readInt();
    double Radius = in.readDouble();
    return Radius;
  }

  public static Planet[] readPlanets(String FileName) {
    In in = new In(FileName);
    int N = in.readInt();
    in.readDouble();
    Planet[] allp = new Planet[N];
    for (int i = 0; i < N; i += 1) {
      double xP = in.readDouble();
      double yP = in.readDouble();
      double xV = in.readDouble();
      double yV = in.readDouble();
      double m = in.readDouble();
      String img = in.readString();
      Planet p = new Planet(xP, yP, xV, yV, m, img);
      allp[i] = p;
    }
    return allp;
  }

  public static void main(String[] args) {
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    double Radius = readRadius(filename);
    Planet[] allp = readPlanets(filename);
    int N = allp.length;

    StdDraw.setScale(-Radius, Radius);
    StdDraw.picture(0, 0 ,"images/starfield.jpg");

    for (Planet p : allp) {
      p.draw();
    }

    StdDraw.enableDoubleBuffering();

    for (int t = 0; t <= T; t += dt) {
      double[] xForces = new double[N];
      double[] yForces = new double[N];
      for (int i = 0; i < N; i += 1) {
        Planet p = allp[i];
        xForces[i] = p.calcNetForceExertedByX(allp);
        yForces[i] = p.calcNetForceExertedByY(allp);
      }

      StdDraw.picture(0, 0 ,"images/starfield.jpg");

      for (int i = 0; i < N; i += 1) {
        Planet p = allp[i];
        p.update(dt, xForces[i], yForces[i]);
        p.draw();
      }

      StdDraw.show();
      StdDraw.pause(10);
    }

    System.out.printf("%d\n", N);
    System.out.printf("%.2e\n", Radius);
    for (Planet p : allp) {
      System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                      p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
    }
  }
}
