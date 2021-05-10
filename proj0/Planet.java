public class Planet {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  private static double G = 6.67e-11;

  public Planet(double xP, double yP, double xV,
                double yV, double m, String img) {
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  public Planet(Planet p) {
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p) {
    double dx = p.xxPos - this.xxPos;
    double dy = p.yyPos - this.yyPos;
    double r = Math.sqrt(dx*dx+dy*dy);
    return r;
  }

  public double calcForceExertedBy(Planet p) {
    double r = this.calcDistance(p);
    double m1 = this.mass;
    double m2 = p.mass;
    double F = (G*m1*m2)/(r*r);
    return F;
  }

  public double calcForceExertedByX(Planet p) {
    double dx = p.xxPos - this.xxPos;
    double r = this.calcDistance(p);
    double F = this.calcForceExertedBy(p);
    double Fx = (F*dx)/r;
    return Fx;
  }

  public double calcForceExertedByY(Planet p) {
    double dy = p.yyPos - this.yyPos;
    double r = this.calcDistance(p);
    double F = this.calcForceExertedBy(p);
    double Fy = (F*dy)/r;
    return Fy;
  }

  public double calcNetForceExertedByX(Planet[] allp) {
    double NetFx = 0;
    for (Planet p : allp) {
      if (!this.equals(p)) {
        NetFx = NetFx + this.calcForceExertedByX(p);
      }
    }
    return NetFx;
  }

  public double calcNetForceExertedByY(Planet[] allp) {
    double NetFy = 0;
    for (Planet p : allp) {
      if (!this.equals(p)) {
        NetFy = NetFy + this.calcForceExertedByY(p);
      }
    }
    return NetFy;
  }

  public void update(double dt, double NetFx, double NetFy) {
    double m = this.mass;
    double Netax = NetFx/m;
    double Netay = NetFy/m;
    this.xxVel = this.xxVel + dt*Netax;
    this.yyVel = this.yyVel + dt*Netay;
    this.xxPos = this.xxPos + dt*xxVel;
    this.yyPos = this.yyPos + dt*yyVel;
  }

  public void draw() {
    StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
  }
}
