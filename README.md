# Concurrent Ticketing System

## Project Overview
This project is a **Concurrent Ticketing System** developed as part of my BEng Software Engineering coursework at the **University of Westminster**. The system is implemented in Java and models a real-world ticketing scenario involving passengers and technicians interacting with a shared Ticket Machine. The project also incorporates **Finite State Processes (FSP)** to design and verify the system using the **LTSA tool**.

I achieved an **exceptional score of 96/100** for this project, highlighting its quality and adherence to concurrency best practices.

---

## Features
- **Multi-threaded Design**: Simulates concurrent interactions between passengers and technicians.
- **Thread Safety**: Ensures mutual exclusion for shared resources (paper and toner).
- **FSP Modeling**: Modeled system behavior using FSP and verified with LTSA.
- **Resource Management**: Implements realistic scenarios of paper and toner exhaustion and replenishment.
- **Randomized Delays**: Simulates real-world timing differences between operations.

---

## System Components
### 1. Ticket Machine
- Manages resources: paper and toner.
- Handles ticket printing requests with synchronization to avoid conflicts.
- Allows refilling of resources by technicians.

### 2. Passenger
- Represents a user purchasing tickets from the Ticket Machine.
- Requests multiple tickets and waits for the machine to be ready if resources are insufficient.

### 3. Ticket Paper Technician
- Refills the Ticket Machine with paper when required.
- Attempts refilling up to three times, with randomized delays.

### 4. Ticket Toner Technician
- Replaces the toner cartridge in the Ticket Machine.
- Attempts replacement up to three times, with randomized delays.

### 5. Finite State Processes (FSP)
- Models the system's behavior for verification.
- Includes processes for the Ticket Machine, Passengers, and Technicians.
- Verified and animated using the LTSA tool.

---

## Skills Gained
- **Concurrency and Multithreading**: Hands-on experience in designing and implementing thread-safe systems.
- **Problem-Solving**: Tackled challenges like mutual exclusion and deadlock prevention.
- **Formal Verification**: Modeled and verified system behavior using the LTSA tool.
- **Java Programming**: Advanced proficiency in Java threading and synchronization.

--- 
