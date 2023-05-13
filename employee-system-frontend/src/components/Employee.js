import React from 'react';
import { useNavigate } from "react-router-dom";

const Employee = ({ employee, deleteEmployee }) => {
    
    const navigate = useNavigate();
    
    // Method that edits the employee data and navigates the page to path="/editEmployee/:id"
    const editEmployee = (e, id) => {
        e.preventDefault();
        navigate(`/editEmployee/${id}`);
    };

    return (
        <tr key={employee.id}>
            <td>
                <div>{employee.firstName}</div>
            </td>
            <td>
                <div>{employee.lastName}</div>
            </td>
            <td>
                <div>{employee.emailId}</div>
            </td>
            <td className='text-right px-6 py-4'>
                <a
                    onClick={(e, id) => editEmployee(e, employee.id)} //Executes the editEmployee method upon clicking
                    className='text-left text-indigo-500 hover:text-indigo-800 px-6 hover: cursor-pointer'>
                    Edit
                </a>
                <a
                    onClick={(e, id) => deleteEmployee(e, employee.id)} //Executes the deleteEmployee method upon clicking
                    className='text-left text-indigo-500 hover:text-indigo-800 px-4 hover: cursor-pointer'>
                    Delete
                </a>
            </td>
        </tr>
    );
};

export default Employee;