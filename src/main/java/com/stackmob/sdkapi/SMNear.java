/**
 * Copyright 2011-2012 StackMob
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stackmob.sdkapi;

/**
 * A "near" query. A near query will add the distance from the search center to query results, and will automatically sort query results by their distance from the search center.
 */
public class SMNear extends SMCondition {
  private final String field;
  private final SMDouble lat;
  private final SMDouble lon;
  private final SMDouble dist;

  /**
   * Create a new SMNear query
   *
   * @param field the geoField to query
   * @param lat the latitude of the location to search
   * @param lon the longitude of the location to search
   * @param dist the distance, in radians, to search, used to limit search results
   */
  public SMNear(String field, SMDouble lat, SMDouble lon, SMDouble dist) {
    this.field = field;
    this.lat = lat;
    this.lon = lon;
    this.dist = dist;
  }
  
  /**
   * Create a new SMNear query
   *
   * @param field the geoField to query
   * @param lat the latitude of the location to search
   * @param lon the longitude of the location to search
   * @param dist the distance, in radians, to search, used to limit search results
   */
  public SMNear(String field, double lat, double lon, double dist) {
    this.field = field;
    this.lat = new SMDouble(lat);
    this.lon = new SMDouble(lon);
    this.dist = new SMDouble(dist);
  }

  public String getField() {
    return field;
  }

  public SMDouble getLat() {
    return lat;
  }

  public SMDouble getLon() {
    return lon;
  }

  public SMDouble getDist() {
    return dist;
  }

  @Override
  public String toString() {
    String withoutDist = String.format("%s near %s, %s", field, lat.toString(), lon.toString());
    if (dist != null)
      return withoutDist + String.format(" within %s radians", dist.toString());
    else
      return withoutDist;
  }
}
