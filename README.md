# Workout Daily

Backend designed to provide the creation and monitoring of a user's workouts. This service was developed in **Clojure**, using the **Ring** and **Compojure** libraries. In addition, data is stored and accessed in a PostgreSQL database using the Korma library.

## Usage

### Database Configuration

Before you can start using it, you must configure the PostgreSQL database on the machine, so you can follow the sequence of steps described in the sql file: [configure_db](http://www.github.com/ThaynanAndrey/workout_daily/tree/master/src/workout_daily/config/database/configure_db.sql).

### Execution

To run the system, just run:   
    ```bash
        lein ring server
    ```

## License

Copyright © 2019

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
