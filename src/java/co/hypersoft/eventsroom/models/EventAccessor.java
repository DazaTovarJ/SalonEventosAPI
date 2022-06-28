/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.models;

import co.hypersoft.eventsroom.database.ConnectionManager;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author jdaza
 */
public class EventAccessor {

    ConnectionManager connection = new ConnectionManager();

    public List<Event> getEvents() throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM events WHERE state = 1";

        Connection conn = connection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            long id = rs.getLong("id");
            String eventType = rs.getString("event_type");
            int guests = rs.getInt("guests");
            LocalDateTime startTime = rs.getTimestamp("start_time").toLocalDateTime();
            Timestamp endTimestamp = rs.getTimestamp("end_time");
            LocalDateTime endTime = null;
            if (!rs.wasNull()) {
                endTime = endTimestamp.toLocalDateTime();
            }
            LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
            LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();

            Event event = null;
            if (endTime != null) {
                event = new Event(id, eventType, guests, startTime, endTime);
            } else {
                event = new Event(id, eventType, guests, startTime);
            }

            event.setCreatedAt(createdAt);
            event.setUpdatedAt(updatedAt);

            events.add(event);
        }

        return events;
    }

    public Event getEvent(long eventId) throws SQLException {
        String query = "SELECT * FROM events WHERE id = ? AND state = 1";
        Event event;

        Connection conn = connection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, eventId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            long id = rs.getLong("id");
            String eventType = rs.getString("event_type");
            int guests = rs.getInt("guests");
            LocalDateTime startTime = rs.getTimestamp("start_time").toLocalDateTime();
            Timestamp endTimestamp = rs.getTimestamp("end_time");
            LocalDateTime endTime = null;
            if (!rs.wasNull()) {
                endTime = endTimestamp.toLocalDateTime();
            }
            LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
            LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();

            if (endTime != null) {
                event = new Event(id, eventType, guests, startTime, endTime);
            } else {
                event = new Event(id, eventType, guests, startTime);
            }

            event.setCreatedAt(createdAt);
            event.setUpdatedAt(updatedAt);

            return event;
        }

        return null;
    }

    public void add(Event event) throws SQLException {
        Arrays.sort(Event.getEventTypes());

        if (Arrays.binarySearch(Event.getEventTypes(), event.getEventType()) < 0) {
            throw new NoSuchElementException("Invalid event type");
        }

        String query = "INSERT INTO events(event_type, guests, start_time, end_time) VALUES (?, ?, ?, ?)";

        System.out.println(event.getEndTime());
        Connection conn = connection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, event.getEventType());
        ps.setInt(2, event.getGuests());
        ps.setTimestamp(3, Timestamp.valueOf(event.getStartTime()));
        ps.setTimestamp(4, Timestamp.valueOf(event.getEndTime()));
        ps.executeUpdate();
    }

    public void addNoEndTime(Event event) throws SQLException {
        Arrays.sort(Event.getEventTypes());

        if (Arrays.binarySearch(Event.getEventTypes(), event.getEventType()) < 0) {
            throw new NoSuchElementException("Invalid event type");
        }

        String query = "INSERT INTO events(event_type, guests, start_time) VALUES (?, ?, ?)";

        Connection conn = connection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, event.getEventType());
        ps.setInt(2, event.getGuests());
        ps.setTimestamp(3, Timestamp.valueOf(event.getStartTime()));
        ps.executeUpdate();
    }

    public void update(Event event) throws SQLException {
        Arrays.sort(Event.getEventTypes());

        if (Arrays.binarySearch(Event.getEventTypes(), event.getEventType()) < 0) {
            throw new NoSuchElementException("Invalid event type");
        }

        String query = "UPDATE events SET event_type = ?, guests = ?, start_time = ?, end_time = ? WHERE id = ?";

        Connection conn = connection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, event.getEventType());
        ps.setInt(2, event.getGuests());
        ps.setTimestamp(3, Timestamp.valueOf(event.getStartTime()));
        ps.setTimestamp(4, Timestamp.valueOf(event.getEndTime()));
        ps.setLong(5, event.getId());
        ps.executeUpdate();
    }

    public void delete(long id) throws SQLException {
        String query = "UPDATE events SET state = 0 WHERE id = ?";

        Connection conn = connection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, id);
        ps.executeUpdate();
    }
}
